import Join from '@/components/pages/join';
import styled from 'styled-components';
import Image from 'next/image';

function JoinPage() {
  return (
    <Wrapper>
      <Title>안녕하세요.</Title>
      <Title>METAMON에 가입 해보세요</Title>
      <Join />
      <RightImage>
        <Image
          src={'/static/meta-grey.png'}
          alt="meta-grey"
          width={700}
          height={487}
        />
      </RightImage>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  max-width: 1000px;
  width: 100%;
  margin: auto;
  padding: 72px 10px;
`;

const Title = styled.h1`
  color: #fff;
  line-height: 45px;
  font-size: 30px;
`;

const RightImage = styled.div`
  height: 537px;
  width: 650px;
  position: absolute;
  right: -80px;
  top: 34px;
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

export default JoinPage;
