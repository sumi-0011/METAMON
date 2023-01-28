import { Button, ErrorText, Input } from '@/components/pages/join/styled';
import useInput from '@/hooks/useInput';
import { ChangeEvent, useState } from 'react';
import styled from 'styled-components';

const VALID_EMAIL_MESSAGE = '이메일 정규식 규칙 위반!!';

interface EmailFormProps {
  email: string;
  handleEmailChange: (e: ChangeEvent<HTMLInputElement>) => void;
  validEmail?: boolean;

  handleEmailAuth: () => void;
}

function EmailForm({
  email,
  validEmail,
  handleEmailChange,
  handleEmailAuth,
}: EmailFormProps) {
  const [requestAuth, setRequestAuth] = useState<boolean>(false);
  const [authentication, handleAuthChange] = useInput();

  const isEmailError = !validEmail && email !== '';

  const handleEmailAuthRequest = () => {
    setRequestAuth(true);
  };

  return (
    <>
      {/* <label htmlFor="join-email">이메일 </label> */}
      <InputWrapper>
        <Input
          type="email"
          id="join-email"
          value={email}
          onChange={handleEmailChange}
          placeholder="이메일"
        />
        {validEmail && (
          <Button onClick={handleEmailAuthRequest} disabled={!validEmail}>
            이메일 인증
          </Button>
        )}
      </InputWrapper>
      {isEmailError && <ErrorText> {VALID_EMAIL_MESSAGE} </ErrorText>}

      {requestAuth ? (
        <InputWrapper>
          <Input
            type="tex"
            value={authentication}
            onChange={handleAuthChange}
            placeholder="인증번호"
          />
          <Button onClick={handleEmailAuth}>인증하기</Button>
        </InputWrapper>
      ) : null}
    </>
  );
}

const InputWrapper = styled.div`
  display: flex;
  gap: 5px;
  width: 217px;
  overflow: visible;
  flex-wrap: nowrap;
`;

export default EmailForm;
