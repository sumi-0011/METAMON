import * as React from 'react';
import { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { wrap } from 'popmotion';
import styled from 'styled-components';
import Image from 'next/image';

const swipeConfidenceThreshold = 10000;
const swipePower = (offset: number, velocity: number) => {
  return Math.abs(offset) * velocity;
};

const variants = {
  enter: (direction: number) => {
    return {
      x: direction > 0 ? 1000 : -1000,
      opacity: 0,
    };
  },
  center: {
    zIndex: 1,
    x: 0,
    opacity: 1,
  },
  exit: (direction: number) => {
    return {
      zIndex: 0,
      x: direction < 0 ? 1000 : -1000,
      opacity: 0,
    };
  },
};

interface SliderProps {
  images: string[];
}

function Slider({ images }: SliderProps) {
  const [[page, direction], setPage] = useState([0, 0]);

  const imageIndex = wrap(0, images.length, page);

  const paginate = (newDirection: number) => {
    setPage([page + newDirection, newDirection]);
  };

  return (
    <Wrapper>
      <AnimatePresence initial={false} custom={direction}>
        <ImgWrapper>
          {/* <InnerWrapper> */}
          <motion.img
            key={page}
            src={images[imageIndex]}
            custom={direction}
            variants={variants}
            initial="enter"
            animate="center"
            exit="exit"
            transition={{
              x: { type: 'spring', stiffness: 300, damping: 30 },
              opacity: { duration: 0.2 },
            }}
            drag="x"
            dragConstraints={{ left: 0, right: 0 }}
            dragElastic={1}
            onDragEnd={(e, { offset, velocity }) => {
              const swipe = swipePower(offset.x, velocity.x);

              if (swipe < -swipeConfidenceThreshold) {
                paginate(1);
              } else if (swipe > swipeConfidenceThreshold) {
                paginate(-1);
              }
            }}
          />
          {/* </InnerWrapper> */}
        </ImgWrapper>
      </AnimatePresence>
      <NextArrow className="next" onClick={() => paginate(1)}>
        <Image
          src={'static/icons/interface-arrows-button-right.svg'}
          width={25}
          height={40}
          alt={'right'}
        />
      </NextArrow>
      <PrevArrow className="prev" onClick={() => paginate(-1)}>
        <Image
          src={'static/icons/interface-arrows-button-left.svg'}
          width={25}
          height={40}
          alt={'left'}
        />
      </PrevArrow>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  margin: 35px 0;
  position: relative;
`;

const ImgWrapper = styled.div`
  width: 880px;
  height: 478px;
  border-radius: 50px;
  overflow: hidden;
  padding: 10px;
  margin: auto;
  img {
    width: calc(100%);
    height: calc(100%);
    object-fit: contain;
  }
  @media ${({ theme }) => theme.device.laptop} {
    height: 400px;
    width: 85%;

    img {
      height: 380px;
    }
  }
  @media ${({ theme }) => theme.device.tablet} {
    width: 85%;
    max-height: 300px;

    img {
      height: 280px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
    height: 200px;
    width: 100%;
    img {
      height: 180px;
    }
  }
`;

const Arrow = styled.div`
  position: absolute;
  top: 0;
  bottom: 0;
  margin: auto;
  height: fit-content;

  color: #fff;

  cursor: pointer;
`;

const PrevArrow = styled(Arrow)`
  left: 0;

  @media ${({ theme }) => theme.device.laptop} {
    left: 35px;
  }
  @media (max-width: 768px) {
    left: 10px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    left: -20px;
  }
`;

const NextArrow = styled(Arrow)`
  right: 0;
  @media ${({ theme }) => theme.device.laptop} {
    right: 35px;
  }
  @media (max-width: 768px) {
    right: 10px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    right: -20px;
  }
`;

export default Slider;
