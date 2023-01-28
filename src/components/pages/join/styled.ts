import styled from 'styled-components';

export const ErrorText = styled.p`
  color: #fff;
  font-size: 0.9rem;
  text-align: start;
`;

export const Button = styled.button`
  height: 40px;
  line-height: 40px;
  width: 100px;
  min-width: 100px;
  border-radius: 20px;
  border: none;
  cursor: pointer;
  background-color: #fff;
  color: ${(props) => (props.disabled ? '#a9a9a9' : '#454545')};
  cursor: ${(props) => (props.disabled ? 'not-allowed' : 'pointer')};
`;

export const FullButton = styled(Button)`
  width: 325px;
`;

export const Input = styled.input`
  width: 217px;
  min-width: 217px;
  height: 40px;
  font-size: 15px;
  border: 0;
  border-radius: 20px;
  outline: none;
  padding-left: 10px;
  background-color: #fff;
  padding: 10px 15px;

  &::placeholder {
    color: #d5d5d5;
    font-size: 0.8rem;
  }
`;
