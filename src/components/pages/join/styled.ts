import styled from 'styled-components';

export const ErrorText = styled.p`
  font-size: 0.7rem;
  text-align: start;
  width: 217px;
  color: #353535;
  padding-left: 5px;
`;

export const Button = styled.button`
  border: none;
  cursor: pointer;
  background-color: #fff;
  cursor: ${(props) => (props.disabled ? 'not-allowed' : 'pointer')};

  color: #0066ff;
  border: 1px solid #0066ff;
  border-radius: 13px;
`;

export const Input = styled.input`
  min-width: 217px;
  font-size: 15px;
  padding: 10px 15px;

  width: 217px;
  height: 40px;
  /* UI Properties */
  background: #ffffff 0% 0% no-repeat padding-box;
  border: 1px solid #707070;
  border-radius: 44px;
  opacity: 1;

  &::placeholder {
    color: #d5d5d5;
    font-size: 0.8rem;
  }
`;
