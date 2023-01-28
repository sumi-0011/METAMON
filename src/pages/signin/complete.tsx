import Image from 'next/image';
import { useRouter } from 'next/router';
import styled from 'styled-components';

function SignInComplete() {
  const router = useRouter();

  const handleMove = () => {
    router.push('/');
  };

  return (
    <Wrapper>
      <InnerWrapper>
        <Image
          src={'/static/meta-white-logo.png'}
          alt="metamon-logo"
          width={100}
          height={64}
        />
        <div>
          <Text>회원가입이</Text>
          <Text> 완료되었습니다!</Text>
        </div>
        <Button onClick={handleMove}>확인</Button>
      </InnerWrapper>
    </Wrapper>
  );
}

const Button = styled.button`
  width: 325px;
  height: 55px;
  cursor: pointer;
  margin-top: 40px;
  border: 1px solid #0066ff;
  border-radius: 44px;
  font-size: 20px;
  color: #0066ff;
  font-weight: bold;
  background-color: #fff;
`;

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  gap: 33px;
`;
const Text = styled.div`
  color: #ffffff;
  font-size: 30px;
  line-height: 45px;
  font-weight: bold;
`;
export default SignInComplete;
