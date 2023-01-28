import EmailForm from '@/components/pages/join/email-form';
import {
  ErrorText,
  Button,
  Input,
  FullButton,
} from '@/components/pages/join/styled';
import useInput from '@/hooks/useInput';
import { useState } from 'react';
import styled from 'styled-components';

const VALID_PASSWORD_MESSAGE = '비밀번호 규칙 위반!! ';
const PASSWORD_MESSAGE =
  '특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식 ( 3 가지 조합)';
function Join() {
  const [name, handleNameChange] = useInput();
  const [birth, handleBirthChange] = useInput();
  const [password, handlePasswordChange, validPassword] = useInput('password');
  const [email, handleEmailChange, validEmail] = useInput('email');

  const [isValidAuth, setIsValidAuth] = useState(false); // 인증 성공

  const isSubmitDisable = !(
    isValidAuth &&
    validEmail &&
    validPassword &&
    name !== '' &&
    birth !== ''
  );

  const handleEmailAuth = () => {
    setIsValidAuth(true);
  };

  return (
    <Wrapper>
      {/* <label htmlFor="join-name">이름</label> */}
      <Input
        type="text"
        id="join-name"
        value={name}
        onChange={handleNameChange}
        placeholder="이름"
      />
      {/* <label htmlFor="join-birth">생년월일</label> */}
      <Input
        type="text"
        value={birth}
        onChange={handleBirthChange}
        id="join-birth"
        placeholder="생년월일"
      />

      <EmailForm
        email={email}
        handleEmailChange={handleEmailChange}
        validEmail={validEmail}
        handleEmailAuth={handleEmailAuth}
      />

      {/* <label htmlFor="join-password">비밀번호</label> */}

      <Input
        type="password"
        value={password}
        onChange={handlePasswordChange}
        id="join-password"
        placeholder="비밀번호"
      />

      {!validPassword && (
        <div>
          <ErrorText>{VALID_PASSWORD_MESSAGE}</ErrorText>
          <ErrorText>{PASSWORD_MESSAGE}</ErrorText>
        </div>
      )}

      <FullButton disabled={isSubmitDisable}>회원가입</FullButton>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 15px;
  padding: 80px 20px;

  max-width: 400px;
  text-align: center;
  margin: auto;
  align-items: center;
`;

export default Join;
