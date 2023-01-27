import { ChangeEvent, useCallback, useState } from 'react';
import debounceFunction from '@/util/debounce';
import { validEmail, validPassword } from '@/util/auth';

const VALID_DELAY = 800;

type InputType = 'email' | 'password' | undefined;

type UseInputReturns = [
  input: string,
  handleChange: (e: ChangeEvent<HTMLInputElement>) => void,
  isValid?: boolean,
];

function useInput(type?: InputType): UseInputReturns {
  const [input, setInput] = useState<string>('');
  const [isValid, setIsValid] = useState(false);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setInput(e.target.value);
    printValue(e.target.value);
  };

  const printValue = useCallback(
    debounceFunction((value: string) => {
      const valid = validInput(type, value);
      console.log('valid: ', valid);
      if (!valid?.isValid && valid?.message) {
        setIsValid(false);
      } else {
        setIsValid(true);
      }
    }, VALID_DELAY),
    [],
  );

  return [input, handleChange, isValid];
}

const validInput = (type: InputType, value: string) => {
  if (type === 'email') return validEmail(value);
  if (type === 'password') return validPassword(value);
};

export default useInput;
