import { confirmEmail } from '@/api/auth';
import { Button, ErrorText, Input } from '@/components/pages/join/styled';
import useInput from '@/hooks/useInput';
import { ChangeEvent, useEffect, useState } from 'react';
import styled from 'styled-components';

const VALID_EMAIL_MESSAGE = '이메일 형식으로 입력해야합니다.';

interface EmailFormProps {
  email: string;
  handleEmailChange: (e: ChangeEvent<HTMLInputElement>) => void;
  validEmail?: boolean;
  isValidAuth: boolean;

  handleEmailAuth: (flag: boolean) => void;
}

function EmailForm({
  email,
  validEmail,
  handleEmailChange,
  handleEmailAuth,
  isValidAuth,
}: EmailFormProps) {
  const [requestAuth, setRequestAuth] = useState<boolean>(false);
  const [authentication, handleAuthChange] = useInput();
  const [confirmCode, setConfirmCode] = useState('1234');
  const isEmailError = !validEmail && email !== '';

  const handleEmailAuthRequest = async () => {
    const data = await confirmEmail(email);

    if (data?.status === 200) {
      setConfirmCode(data.data.confirmCode);
      setRequestAuth(true);
    }
    if (data?.status === 400) {
      alert(data.message);
    }
  };

  useEffect(() => {
    const flag = authentication === confirmCode;

    if (flag) {
      handleEmailAuth(true);
    } else {
      handleEmailAuth(false);
    }
  }, [authentication]);

  return (
    <>
      <div>
        <Input
          type="email"
          id="join-email"
          value={email}
          onChange={handleEmailChange}
          placeholder="이메일"
        />
        {isEmailError && <ErrorText> {VALID_EMAIL_MESSAGE} </ErrorText>}
      </div>

      {requestAuth ? (
        <InputWrapper>
          <Input
            type="tex"
            value={authentication}
            onChange={handleAuthChange}
            placeholder="인증번호"
          />
          <NonValid className={isValidAuth ? 'ok' : ''} />
          {/* <AuthNumberRequestBtn onClick={handleEmailAuth}>
            인증하기
          </AuthNumberRequestBtn> */}
        </InputWrapper>
      ) : null}

      <InputWrapper>
        {validEmail && (
          <AuthNumberRequestBtn
            onClick={handleEmailAuthRequest}
            disabled={!validEmail}
          >
            이메일 인증
          </AuthNumberRequestBtn>
        )}
      </InputWrapper>
    </>
  );
}

const InputWrapper = styled.div`
  display: flex;
  gap: 5px;
  width: 217px;
  overflow: visible;
  flex-wrap: nowrap;
  align-items: center;
`;

const AuthNumberRequestBtn = styled(Button)`
  width: 88px;
  height: 27px;
  min-width: 88px;

  font-size: 10px;
  color: #0066ff;
  line-height: 27px;
  position: relative;
  top: -3px;
`;

const NonValid = styled.div`
  width: 17px;
  height: 17px;
  min-width: 17px;
  /* UI Properties */
  background: #ffffff 0% 0% no-repeat padding-box;
  border: 1px solid #707070;
  opacity: 0.63;
  border-radius: 50%;
  margin-left: 1px;
  transition: all 1s;
  &::before {
    content: '';
    border-radius: 50%;
    display: block;
    width: 11px;
    height: 11px;
    background: #0066ff;
    position: relative;
    top: 2.3px;
    left: 2.3px;
    opacity: 0;
    transition: all 0.5s;
  }
  &.ok {
    opacity: 1;
    &::before {
      opacity: 1;
    }
  }
`;
export default EmailForm;
