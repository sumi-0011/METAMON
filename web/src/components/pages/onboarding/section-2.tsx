import {
  BigTitle,
  Desc,
  EmojiWrapperStyle,
  LeftBox,
  RightBox,
  WrapperStyle,
} from '@/components/pages/onboarding/style';
import styled from 'styled-components';
import Image from 'next/image';
import useScrollFadeIn from '@/hooks/useScrollFadeIn';

function Section2() {
  const down1 = useScrollFadeIn('down', 1, 0);
  const down2 = useScrollFadeIn('down', 1, 0);
  const down3 = useScrollFadeIn('down', 1, 0);
  const down4 = useScrollFadeIn('down', 1, 0);
  const right1 = useScrollFadeIn('right', 1, 0);
  const left = useScrollFadeIn('left', 1, 0);

  return (
    <Wrapper>
      <BigTitleWrapper {...down1}>
        <BigTitle>세상이 바뀌어도</BigTitle>
        <BigTitle>내가 나임을</BigTitle>
        <BigTitle>알 수 있도록</BigTitle>
      </BigTitleWrapper>
      <EmojiWrapper {...down2}>
        <Image
          src={'/static/emoji2.png'}
          alt="emoji2"
          width={268}
          height={268}
        />
      </EmojiWrapper>
      <MockImageWrapper {...left}>
        <Image
          src="/static/Mockup2.png"
          alt="mockup1"
          width={400}
          height={800}
        />
      </MockImageWrapper>
      <DescWrapper {...right1}>
        <Desc>어디에 누구와 있든</Desc>
        <Desc>내가 나임을 알 수 있게,</Desc>
        <Desc>현실과 통합된</Desc>
        <Desc>메타버스 신분증을</Desc>
        <Desc>발급받을 수 있어요.</Desc>
      </DescWrapper>
    </Wrapper>
  );
}

const Wrapper = styled(WrapperStyle)`
  height: 1500px;
  @media ${({ theme }) => theme.device.desktop} {
  }
  @media ${({ theme }) => theme.device.laptop} {
    height: 1200px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    height: 1030px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    height: 780px;
  }
`;

const DescWrapper = styled(RightBox)`
  bottom: 380px;
  z-index: 1;
  @media ${({ theme }) => theme.device.mobile} {
    bottom: 180px;
  }
`;

const MockImageWrapper = styled(LeftBox)`
  width: fit-content;
  position: absolute;
  bottom: 0;

  z-index: 0;
  @media ${({ theme }) => theme.device.desktop} {
    img {
      width: 350px;
      height: 750px;
    }
  }
  @media ${({ theme }) => theme.device.laptop} {
    img {
      width: 300px;
      height: 600px;
    }
  }
  @media ${({ theme }) => theme.device.tablet} {
    img {
      width: 280px;
      height: 600px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
    img {
      width: 180px;
      height: 380px;
    }
  }
`;

const BigTitleWrapper = styled(RightBox)`
  top: 160px;
`;

const EmojiWrapper = styled(EmojiWrapperStyle)`
  position: absolute;
  top: 350px;
  right: 800px;

  img {
    width: 220px;
    height: 220px;
  }

  @media ${({ theme }) => theme.device.desktop} {
    right: 670px;
    top: 370px;
    img {
      width: 200px;
      height: 200px;
    }
  }
  @media ${({ theme }) => theme.device.laptop} {
    right: 550px;
    top: 320px;
    img {
      width: 170px;
      height: 170px;
    }
  }
  @media ${({ theme }) => theme.device.tablet} {
    right: 400px;
    top: 250px;

    img {
      width: 120px;
      height: 120px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
    right: 230px;
    top: 240px;

    img {
      width: 80px;
      height: 80px;
    }
  }
`;

export default Section2;
