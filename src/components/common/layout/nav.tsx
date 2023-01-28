import { Flex } from '@/components/common/flex';
import { useRouter } from 'next/router';
import { useState } from 'react';
import styled from 'styled-components';

type SelectedPageType = '/intro' | '/way' | '/signin';
function Nav() {
  const router = useRouter();
  const selectedPage = router.pathname;

  const handleNavItemClick = (path: SelectedPageType) => {
    router.push(path);
  };

  return (
    <Wrapper>
      <Item
        className={selectedPage === '/intro' ? 'selected' : ''}
        onClick={() => handleNavItemClick('/intro')}
      >
        METAMON 소개
      </Item>
      <Item
        className={selectedPage === '/way' ? 'selected' : ''}
        onClick={() => handleNavItemClick('/way')}
      >
        사용 방법
      </Item>
      <SignInWrapper onClick={() => handleNavItemClick('/signin')}>
        Sign in
      </SignInWrapper>
    </Wrapper>
  );
}

const Wrapper = styled.nav`
  display: flex;
  gap: 50px;
  color: #a1a1a1;
  align-items: center;
`;

const Item = styled.div`
  position: relative;
  min-width: 72px;
  text-align: center;
  &.selected::before {
    margin: auto;
    position: absolute;
    top: -24px;
    left: 0;
    right: 0;
    content: '';
    width: 72px;
    height: 9px;
    display: block;
    background-color: var(--basic-color);
    border-radius: 0 0 9px 9px;
  }
`;

const SignInWrapper = styled(Flex)`
  color: #4d4f5c;
  padding-left: 20px;
  &::before {
    content: '';
    height: 17px;
    width: 0px;
    border: 0.1px solid #a1a1a1;
    background-color: #a1a1a1;
    position: relative;
    left: -30px;
  }
`;

export default Nav;
