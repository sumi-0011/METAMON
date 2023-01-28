import { Flex } from '@/components/common/flex';
import { useRouter } from 'next/router';
import { useState } from 'react';
import styled from 'styled-components';

type SelectedPageType = '/intro' | '/way' | '/signin';

interface NavProps {}

function Nav({}: NavProps) {
  const router = useRouter();
  const selectedPage = router.pathname;

  const [isNavOpen, setIsNavOpen] = useState(false);

  const handleNavItemClick = (path: SelectedPageType) => {
    router.push(path);
  };

  const handleSubNavOpen = () => {
    setIsNavOpen(true);
  };

  const handleSubNavClose = () => {
    setIsNavOpen(false);
  };

  return (
    <Wrapper onMouseOver={handleSubNavOpen} onMouseLeave={handleSubNavClose}>
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

      <SubNav className={isNavOpen ? 'open' : ''}>
        <SubNavInner>
          <SubItemWrapper>
            <div>METAMON 소개</div>
            <div>서비스 취지</div>
          </SubItemWrapper>
          <SubItemWrapper>사용 방법</SubItemWrapper>
        </SubNavInner>
      </SubNav>
    </Wrapper>
  );
}

const SubNavInner = styled.div`
  float: right;
  width: 352px;
  margin: 20px 30px;
  display: flex;
  gap: 55px;
`;

const Wrapper = styled.nav`
  display: flex;
  gap: 50px;
  color: #a1a1a1;
  align-items: center;
`;

const SubItemWrapper = styled.div`
  display: flex;
  min-width: 72px;
  flex-direction: column;
  gap: 20px;
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

const SubNav = styled.div`
  position: absolute;
  transition: all 1s;
  background-color: #fff;
  top: 70px;
  width: 100%;
  right: 0;
  left: 0;
  height: 0;
  overflow: hidden;
  &.open {
    height: 150px;
  }
`;
export default Nav;
