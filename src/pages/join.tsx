import useInput from '@/hooks/useInput';
import { useState } from 'react';
import styled from 'styled-components';

const VALID_EMAIL_MESSAGE = '이메일 정규식 규칙 위반!!';
const VALID_PASSWORD_MESSAGE =
  '비밀번호 규칙 위반!! 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식 ( 3 가지 조합)';

function Join() {
  const [name, handleNameChange] = useInput();
  const [birth, handleBirthChange] = useInput();
  const [email, handleEmailChange, validEmail] = useInput('email');
  const [password, handlePasswordChange, validPassword] = useInput('password');

  const [requestAuth, setRequestAuth] = useState<boolean>(false);
  const [authentication, handleAuthChange] = useInput();
  const [isValidAuth, setIsValidAuth] = useState(false); // 인증 성공

  const isEmailError = !validEmail && email !== '';
  const isSubmit =
    isValidAuth && validEmail && validPassword && name !== '' && birth !== '';

  const handleEmailAuthRequest = () => {
    setRequestAuth(true);
  };

  const handleEmailAuth = () => {
    setIsValidAuth(true);
  };

  return (
    <Wrapper>
      <h1>회원가입</h1>

      <label htmlFor="join-name">이름</label>
      <input
        type="text"
        id="join-name"
        value={name}
        onChange={handleNameChange}
      />
      <label htmlFor="join-birth">생년월일</label>
      <input
        type="text"
        value={birth}
        onChange={handleBirthChange}
        id="join-birth"
      />
      <label htmlFor="join-email">이메일 </label>
      <div>
        <input
          type="email"
          id="join-email"
          value={email}
          onChange={handleEmailChange}
        />
        <button onClick={handleEmailAuthRequest} disabled={!validEmail}>
          이메일 인증
        </button>
      </div>
      {isEmailError && VALID_EMAIL_MESSAGE}
      {requestAuth && (
        <div>
          <input
            type="tex"
            value={authentication}
            onChange={handleAuthChange}
          />
          <button onClick={handleEmailAuth}>인증하기</button>
        </div>
      )}
      <label htmlFor="join-password">비밀번호</label>
      <input
        type="password"
        value={password}
        onChange={handlePasswordChange}
        id="join-password"
      />
      {!validPassword && VALID_PASSWORD_MESSAGE}

      <button disabled={!isSubmit}>회원가입</button>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 20px;
`;

export default Join;
