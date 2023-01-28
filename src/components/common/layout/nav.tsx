import { Flex } from '@/components/common/flex';
import { useRouter } from 'next/router';
import { useState } from 'react';
import styled from 'styled-components';

type SelectedPageType = '/intro' | '/way' | '/signin';

interface NavProps {}

function Nav({}: NavProps) {
  const router = useRouter();
  const selectedPage = router.pathname;

  // const [isNavOpen, setIsNavOpen] = useState(false);

  const handleChangePath = (path: SelectedPageType) => {
    router.push(path);
  };

  // const handleSubNavOpen = () => {
  //   setIsNavOpen(true);
  // };

  // const handleSubNavClose = () => {
  //   setIsNavOpen(false);
  // };

  return (
    <Wrapper>
      <InnerWrapper
      // onMouseOver={handleSubNavOpen}
      // onMouseLeave={handleSubNavClose}
      >
        <Item
          className={selectedPage === '/intro' ? 'selected' : ''}
          onClick={() => handleChangePath('/intro')}
        >
          METAMON 소개
        </Item>
        <Item
          className={selectedPage === '/way' ? 'selected' : ''}
          onClick={() => handleChangePath('/way')}
        >
          사용 방법
        </Item>
        {/* <SubNav className={isNavOpen ? 'open' : ''}>
          <SubNavInner>
            <SubItemWrapper>
              <SubItem>METAMON 소개</SubItem>
              <SubItem>서비스 취지</SubItem>
            </SubItemWrapper>
            <SubItemWrapper>
              <SubItem>사용 방법</SubItem>
            </SubItemWrapper>
          </SubNavInner>
        </SubNav> */}
      </InnerWrapper>

      <SignInWrapper onClick={() => handleChangePath('/signin')}>
        회원가입하기
      </SignInWrapper>
    </Wrapper>
  );
}

const SubNavInner = styled.div`
  float: right;
  width: 363px;
  margin: 20px 30px;
  display: flex;
  gap: 60px;
`;

const Wrapper = styled.nav`
  display: flex;
  gap: 30px;
  color: #a1a1a1;
  align-items: center;
  height: 95px;
  padding: 0 30px;
  font-size: 15px;
  @media ${({ theme }) => theme.device.tablet} {
    display: none;
  }
`;

const InnerWrapper = styled.div`
  display: flex;
  color: #a1a1a1;
  align-items: center;
  padding: 15px 0;
  gap: 20px;
`;

const SubItemWrapper = styled.div`
  display: flex;
  min-width: 72px;
  flex-direction: column;
  gap: 20px;
`;

const SubItem = styled.div`
  width: fit-content;

  cursor: pointer;
  position: relative;
  &::after {
    transition: all 0.8s;
    content: '';
    height: 0px;
    width: 0px;
    position: absolute;
    border: 1px solid #fff;

    bottom: -5px;
    right: 0;
    left: 0;
  }

  &:hover {
    &::after {
      width: 100%;
      border: 1px solid var(--basic-color);
    }
  }
`;

const Item = styled.div`
  --color: #a1a1a1;
  position: relative;
  min-width: 115px;
  width: 125px;
  text-align: center;
  cursor: pointer;
  padding: 5px;

  &:hover {
    color: var(--basic-color);
  }
  &.selected {
    color: var(--basic-color);

    &::before {
      @keyframes fadeIn {
        0% {
          opacity: 0;
        }
        100% {
          opacity: 1;
        }
      }

      margin: auto;
      position: absolute;
      top: -32px;
      left: 0;
      right: 0;
      content: '';
      width: 72px;
      height: 12px;
      display: block;
      background-color: var(--basic-color);
      border-radius: 0 0 9px 9px;
      animation-name: fadeIn;
      animation-duration: 0.5s;
    }
  }
`;

const SignInWrapper = styled.button`
  color: #4d4f5c;
  padding-left: 20px;
  cursor: pointer;
  color: #fff;
  padding: 5px 20px;
  border-radius: 20px;

  width: 180px;
  height: 39px;

  background-color: var(--basic-color);
  border: 1px solid var(--basic-color);
`;

const SubNav = styled.div`
  position: absolute;
  transition: all 1s;
  background-color: #fff;
  top: 95px;
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
