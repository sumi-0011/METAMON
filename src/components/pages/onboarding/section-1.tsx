import styled from 'styled-components';
import Image from 'next/image';
import {
  EmojiWrapperStyle,
  WrapperStyle,
} from '@/components/pages/onboarding/style';

function Section1() {
  return (
    <Wrapper>
      <TextWrapper>
        <BigTitleWrapper>
          <BigTitle>이것도 나고 </BigTitle>
          <BigTitle>이것도 나야.</BigTitle>
        </BigTitleWrapper>

        <DescWrapper>
          <Desc>메타버스 속 내 정체성 지킴이,</Desc>
          <Desc>메타몽과 함께</Desc>
          <br />
          <Desc> </Desc>
          <Desc>다양한 세상 속 내 모습을 한번에 </Desc>
          <Desc>관리하세요.</Desc>
        </DescWrapper>
      </TextWrapper>
      <Emoji>
        <Image
          src={'/static/emoji1.png'}
          alt="emoji1"
          width={268}
          height={268}
        />
      </Emoji>

      <MockImageWrapper>
        <Image src="/static/Mockup.png" alt="mockup1" fill />
      </MockImageWrapper>
    </Wrapper>
  );
}

const Wrapper = styled(WrapperStyle)`
  height: 1850px;

  max-width: 1600px;
  margin: 0 auto;
  font-size: var(--top-size);

  @media ${({ theme }) => theme.device.desktop} {
    height: 1800px;
  }
  @media ${({ theme }) => theme.device.laptop} {
    height: 1560px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    height: 1000px;
  }

  @media ${({ theme }) => theme.device.mobile} {
    --top-size: 6px;
    height: 900px;
  }
`;

const MockImageWrapper = styled.div`
  position: absolute;
  bottom: 0;

  width: 900px;
  max-width: 1600px;
  height: 1000px;

  right: 50px;
  z-index: 0;

  @media ${({ theme }) => theme.device.desktop} {
    width: 800px;
    height: 900px;
  }

  @media ${({ theme }) => theme.device.laptop} {
    width: 700px;
    height: 810px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    width: 400px;
    height: 470px;
    right: 20px;
  }

  @media ${({ theme }) => theme.device.mobile} {
    width: 300px;
    height: 350px;
  }
`;

const TextWrapper = styled.div`
  position: absolute;
  top: 285px;
  left: 254px;
  z-index: 1;

  @media ${({ theme }) => theme.device.desktop} {
    left: 100px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    left: 50px;
  }
  @media ${({ theme }) => theme.device.mobile} {
    left: 20px;
  }
`;

const Emoji = styled(EmojiWrapperStyle)`
  top: 400px;
  left: 897px;

  @media ${({ theme }) => theme.device.desktop} {
    left: 747px;
  }

  @media ${({ theme }) => theme.device.laptop} {
    left: 500px;
  }

  @media ${({ theme }) => theme.device.tablet} {
    left: 320px;
    top: 350px;
  }

  @media ${({ theme }) => theme.device.mobile} {
    left: 230px;
    top: 350px;
  }
`;

const BigTitleWrapper = styled.div`
  text-align: left;
`;

const BigTitle = styled.div`
  text-align: left;
  font-size: 6em;
  font-weight: bold;
  letter-spacing: 0px;
  color: #010101;
`;

const DescWrapper = styled.div`
  margin-top: 120px;

  @media ${({ theme }) => theme.device.laptop} {
    margin-top: 80px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    margin-top: 60px;
  }
`;

const Desc = styled.div`
  text-align: left;
  font-size: 2.5em;
  font-weight: bold;

  letter-spacing: 0px;
  color: #676767;
`;

export default Section1;
