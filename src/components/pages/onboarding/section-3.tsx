import {
  BigTitle,
  Desc,
  LeftBox,
  WrapperStyle,
} from '@/components/pages/onboarding/style';
import styled from 'styled-components';
import Image from 'next/image';
import useScrollFadeIn from '@/hooks/useScrollFadeIn';

function Section3() {
  const up = useScrollFadeIn('up', 1, 0);
  const up2 = useScrollFadeIn('up', 1, 0);
  const up3 = useScrollFadeIn('up', 1, 0);

  return (
    <Wrapper>
      <BigTitleWrapper>
        <div {...up}>
          <BigTitle>메타버스 신분증</BigTitle>
          <BigTitle>메타몽.</BigTitle>
        </div>
        <DescWrapper {...up2}>
          <Desc>간단한 계정 인증을 통해</Desc>
          <br />
          <Desc>메타버스 속 나의 신분증을</Desc>
          <Desc>발급받아보세요.</Desc>
        </DescWrapper>
        <MakeButton>
          <button>신분증 만들러가기</button>
        </MakeButton>
      </BigTitleWrapper>
      <EmojiWrapper {...up3}>
        <Image
          src={'/static/emoji3.png'}
          alt="emoji2"
          width={210}
          height={210}
        />
      </EmojiWrapper>
      <MockImageWrapper>
        <Image src="/static/Mockup3.png" alt="mockup1" fill />
      </MockImageWrapper>
    </Wrapper>
  );
}

const Wrapper = styled(WrapperStyle)`
  height: 1900px;
  @media ${({ theme }) => theme.device.desktop} {
    height: 1800px;
  }
  @media ${({ theme }) => theme.device.laptop} {
    height: 1630px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    height: 1150px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    height: 830px;
  }
`;

const EmojiWrapper = styled.div`
  position: absolute;
  top: 230px;
  left: 930px;
  @media ${({ theme }) => theme.device.desktop} {
    top: 110px;
    left: 770px;
    img {
      width: 180px;
      height: 180px;
    }
  }

  @media ${({ theme }) => theme.device.laptop} {
    left: 630px;
    top: 120px;

    img {
      width: 140px;
      height: 140px;
    }
  }
  @media ${({ theme }) => theme.device.tablet} {
    left: 380px;
    top: 135px;

    img {
      width: 90px;
      height: 90px;
    }
  }
  @media ${({ theme }) => theme.device.mobile} {
    left: 270px;
    top: 140px;

    img {
      width: 70px;
      height: 70px;
    }
  }
`;

const MockImageWrapper = styled.div`
  width: 100%;
  height: 950px;
  position: absolute;
  bottom: 0;

  @media ${({ theme }) => theme.device.desktop} {
    height: 780px;
  }
  @media ${({ theme }) => theme.device.laptop} {
    height: 630px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    height: 530px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    height: 320px;
  }
  @media only screen and (max-width: 375px) {
    height: 270px;
  }
`;
const BigTitleWrapper = styled(LeftBox)`
  top: 300px;

  @media ${({ theme }) => theme.device.desktop} {
    top: 160px;
  }
`;

const DescWrapper = styled.div`
  margin-top: 120px;
  @media ${({ theme }) => theme.device.tablet} {
    margin-top: 60px;
  }
  /* top: 650px; */
`;

const MakeButton = styled.div`
  /* top: 900px;
   */
  margin-top: 120px;
  @media ${({ theme }) => theme.device.tablet} {
    margin-top: 60px;
  }
  button {
    border-radius: 42px;
    width: 452px;
    height: 83px;
    background-color: var(--basic-color);
    border: 1px solid var(--basic-color);
    color: #fff;
    font-size: 1.8em;
    font-weight: bold;
    @media ${({ theme }) => theme.device.laptop} {
      width: 352px;
      height: 63px;
    }
    @media ${({ theme }) => theme.device.tablet} {
      width: 270px;
      height: 50px;
    }
    @media ${({ theme }) => theme.device.mobile} {
      width: 200px;
      height: 40px;
    }
  }
`;

export default Section3;
