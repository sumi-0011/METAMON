import { sign_up } from '@/api/auth';
import EmailForm from '@/components/pages/join/email-form';
import { ErrorText, Button, Input } from '@/components/pages/join/styled';
import useInput from '@/hooks/useInput';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import styled from 'styled-components';

// const VALID_PASSWORD_MESSAGE = '비밀번호 규칙 위반!! ';
const PASSWORD_MESSAGE = '특수문자/문자/숫자 형태의 8~15자리 이내';

function Join() {
  const router = useRouter();

  const [name, handleNameChange] = useInput();
  const [birth, handleBirthChange] = useInput();
  const [password, handlePasswordChange, validPassword] = useInput('password');
  const [email, handleEmailChange, validEmail] = useInput('email');
  const [isValidAuth, setIsValidAuth] = useState(false);
  const isSubmitDisable = !(
    isValidAuth &&
    validPassword &&
    name !== '' &&
    birth !== ''
  );

  const handleEmailAuth = (flag: boolean) => {
    setIsValidAuth(flag);
  };

  const handleSignIn = async () => {
    if (isValidAuth) {
      console.log(name, birth, password, email);

      const data = await sign_up({
        userName: name,
        email,
        password,
        birth,
      });

      if (data?.status === 200) {
        // TODO : 회원가입 완료, 페이지ㅣ 이동
        router.push('/signin/complete');
      }
    }
  };

  useEffect(() => {
    setIsValidAuth(false);
  }, [email]);

  return (
    <Wrapper>
      <Title>회원가입</Title>
      <FormWrapper>
        <Input
          type="text"
          id="join-name"
          value={name}
          onChange={handleNameChange}
          placeholder="이름"
        />
        <Input
          type="date"
          value={birth}
          onChange={handleBirthChange}
          id="join-birth"
          placeholder="생년월일"
        />

        <div>
          <Input
            type="password"
            value={password}
            onChange={handlePasswordChange}
            id="join-password"
            placeholder="비밀번호"
          />

          {!validPassword && password !== '' ? (
            <ErrorText>{PASSWORD_MESSAGE}</ErrorText>
          ) : null}
        </div>
        <EmailForm
          email={email}
          handleEmailChange={handleEmailChange}
          validEmail={validEmail}
          handleEmailAuth={handleEmailAuth}
          isValidAuth={isValidAuth}
        />
      </FormWrapper>

      <FullButton disabled={isSubmitDisable} onClick={handleSignIn}>
        회원가입
      </FullButton>
    </Wrapper>
  );
}

const FullButton = styled(Button)`
  margin-top: 24px;
  width: 325px;
  height: 55px;
  border-radius: 44px;
  font-weight: bold;
`;

const FormWrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 15px;
`;
const Title = styled.h2`
  color: #464646;
  font-size: 20px;
`;
const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 14px;
  background-color: #fff;
  border-radius: 28px;
  padding: 35px 76px;
  width: 478px;
  min-height: 469px;
  text-align: center;
  align-items: center;
  margin: auto;
  margin-top: 47px;
  transition: height 1s;
  justify-content: space-between;
`;

export default Join;
