import Input from '@/components/common/input';
import EmailForm from '@/components/pages/join/email-form';
import useInput from '@/hooks/useInput';
import { useState } from 'react';
import styled from 'styled-components';

const VALID_PASSWORD_MESSAGE = '비밀번호 규칙 위반!! ';

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
      <h1>회원가입</h1>

      <label htmlFor="join-name">이름</label>
      <Input
        type="text"
        id="join-name"
        value={name}
        onChange={handleNameChange}
      />
      <label htmlFor="join-birth">생년월일</label>
      <Input
        type="text"
        value={birth}
        onChange={handleBirthChange}
        id="join-birth"
      />

      <EmailForm
        email={email}
        handleEmailChange={handleEmailChange}
        validEmail={validEmail}
        handleEmailAuth={handleEmailAuth}
      />

      <label htmlFor="join-password">비밀번호</label>
      <Input
        type="password"
        value={password}
        onChange={handlePasswordChange}
        id="join-password"
        placeholder="특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식 ( 3 가지 조합)"
      />
      <ErrorText>{!validPassword && VALID_PASSWORD_MESSAGE}</ErrorText>

      <Button disabled={isSubmitDisable}>회원가입</Button>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 20px;

  max-width: 1000px;
`;

const ErrorText = styled.p`
  color: red;
  font-size: 0.7rem;
`;

const Button = styled.button`
  height: 40px;
  line-height: 40px;
  width: 100px;
  border-radius: 15px;
  border: none;
  cursor: pointer;

  color: ${(props) => (props.disabled ? '#a9a9a9' : '#454545')};
  cursor: ${(props) => (props.disabled ? 'not-allowed' : 'pointer')};
`;
export default Join;
