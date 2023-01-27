import Input from '@/components/common/input';
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
    <Wrapper>
      <label htmlFor="join-email">이메일 </label>
      <InputWrapper>
        <Input
          type="email"
          id="join-email"
          value={email}
          onChange={handleEmailChange}
        />
        <Button onClick={handleEmailAuthRequest} disabled={!validEmail}>
          이메일 인증
        </Button>
      </InputWrapper>
      <ErrorText>{isEmailError && VALID_EMAIL_MESSAGE}</ErrorText>

      {requestAuth && (
        <div>
          <Input
            type="tex"
            value={authentication}
            onChange={handleAuthChange}
          />
          <Button onClick={handleEmailAuth}>인증하기</Button>
        </div>
      )}
    </Wrapper>
  );
}

const InputWrapper = styled.div`
  display: flex;
  input {
    flex: 1;
  }
`;

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 10px;
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

  color: ${(props) => (props.disabled ? '#a9a9a9' : '#454545')};
  cursor: ${(props) => (props.disabled ? 'not-allowed' : 'pointer')};
`;

export default EmailForm;
