import Image from 'next/image';
import styled from 'styled-components';

function MainSection() {
  return (
    <Wrapper>
      <InnerWrapper>
        <LeftBox>
          <Image
            src={'/static/meta-white-text.png'}
            alt="metamon-text-logo"
            width={420}
            height={72}
          />
          <h2>당신을 위한 메타버스 신분증</h2>
        </LeftBox>
        <RightImage>
          <Image
            src={'/static/meta-grey.png'}
            alt="meta-grey"
            width={700}
            height={487}
          />
        </RightImage>
      </InnerWrapper>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  background-color: var(--basic-color);
  height: calc(100vh - 95px);
  width: 100%;
`;

const InnerWrapper = styled.div`
  position: relative;

  width: 100%;
  max-width: 1600px;
  height: 100%;
  margin: 0 auto;
`;

const LeftBox = styled.div`
  position: absolute;
  left: 180px;
  color: #fff;

  margin: auto;
  top: -212px;
  bottom: 0;
  height: fit-content;

  h2 {
    margin-top: 48px;
    font-size: 30px;
  }

  @media only screen and (max-width: 1200px) {
    left: 125px;
  }
  @media ${({ theme }) => theme.device.laptop} {
    left: 100px;
    top: -155px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    text-align: center;
  }

  @media ${({ theme }) => theme.device.mobile} {
    img {
      width: 250px;
      height: 40px;
    }
    h2 {
      display: none;
    }
  }
`;

const RightImage = styled.div`
  height: 537px;
  width: 650px;
  position: absolute;
  right: -80px;
  top: -64px;
  bottom: 0;
  margin: auto;
  @media ${({ theme }) => theme.device.laptop} {
    top: 50px;
    right: -150px;
    img {
      width: 600px;
      height: 400px;
    }
  }

  @media ${({ theme }) => theme.device.tablet} {
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    width: fit-content;
    margin: auto;
    height: fit-content;
    img {
      width: 600px;
      position: relative;
    }
  }
  @media (max-width: 545px) {
    img {
      right: 100px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
  }
`;
export default MainSection;
