import styled from 'styled-components';

const Input = styled.input`
  height: 40px;
  font-size: 15px;
  border: 0;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
  padding: 10px 15px;

  &::placeholder {
    color: #a2a2a2;
    font-size: 0.7rem;
  }
`;

export default Input;
