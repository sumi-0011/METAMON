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
  max-height: 730px;
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
    left: 80px;
    img {
      width: 370px;
      height: 60px;
    }
    h2 {
      font-size: 20px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
    /* TODO */
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
`;
export default MainSection;
