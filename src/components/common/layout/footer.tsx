import styled from 'styled-components';
import Image from 'next/image';

function Footer() {
  return (
    <Wrapper>
      <Image
        src={'/static/meta-icon-text.png'}
        width={150}
        height={30}
        alt={'metamon-logo'}
      />

      <Copyright>@Andes. 2023 All rights reserved</Copyright>
    </Wrapper>
  );
}

const Wrapper = styled.footer`
  width: 100%;
  height: 134px;
  background-color: #fff;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  gap: 28px;
`;

const Copyright = styled.div`
  color: #c2c2c2;
  font-weight: 12px;
  line-height: 18px;
`;
export default Footer;
