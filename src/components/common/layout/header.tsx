import { Flex } from '@/components/common/flex';
import Nav from '@/components/common/layout/nav';
import Image from 'next/image';
import { useRouter } from 'next/router';
import { useState } from 'react';
import styled from 'styled-components';

function Header() {
  const router = useRouter();

  const handleChangePath = (path: string) => {
    router.push(path);
  };

  return (
    <div>
      <Wrapper>
        <LeftBox>
          <Logo onClick={() => handleChangePath('/')}>
            <Image
              src={'/static/meta-icon-text.png'}
              width={210}
              height={43}
              alt={'metamon-logo'}
            />
          </Logo>
        </LeftBox>
        <Nav />
      </Wrapper>
    </div>
  );
}

const Wrapper = styled.div`
  position: relative;
  width: 100%;
  height: 95px;
  background-color: #fff;

  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid #eee;
`;

const LeftBox = styled(Flex)`
  gap: 50px;
  height: 95px;

  padding: 15px 30px;

  @media ${({ theme }) => theme.device.mobile} {
    padding: 10px;
  }
`;

const Logo = styled.div`
  color: var(--basic-color);
  font-size: 1.875rem;
  font-weight: bold;
  line-height: 40px;
  cursor: pointer;
  @media ${({ theme }) => theme.device.tablet} {
    img {
      width: 150px;
      height: 38px;
    }
  }

  @media ${({ theme }) => theme.device.mobile} {
    img {
      width: 108px;
      height: 26px;
    }
  }
`;

export default Header;
