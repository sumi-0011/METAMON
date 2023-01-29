import { Flex } from '@/components/common/flex';
import { useRouter } from 'next/router';
import { useState } from 'react';
import styled from 'styled-components';

type SelectedPageType = '/intro' | '/way' | '/signin';

interface NavProps {}

function Nav({}: NavProps) {
  const router = useRouter();
  const selectedPage = router.pathname;

  const handleChangePath = (path: SelectedPageType) => {
    router.push(path);
  };

  return (
    <Wrapper>
      <InnerWrapper>
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
      </InnerWrapper>

      <SignInWrapper onClick={() => handleChangePath('/signin')}>
        회원가입하기
      </SignInWrapper>
    </Wrapper>
  );
}

const Wrapper = styled.nav`
  display: flex;
  gap: 30px;
  color: #a1a1a1;
  align-items: center;
  height: 95px;
  padding: 0 30px;
  font-size: 15px;
  @media ${({ theme }) => theme.device.tablet} {
    /* display: none; */
    gap: 10px;
    font-size: 13px;
  }

  @media only screen and (max-width: 600px) {
    font-size: 10px;
    padding: 0 10px;
  }
`;

const InnerWrapper = styled.div`
  display: flex;
  color: #a1a1a1;
  align-items: center;
  padding: 15px 0;
  gap: 20px;
  @media ${({ theme }) => theme.device.tablet} {
    gap: 5px;
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
      height: 9px;
      display: block;
      background-color: var(--basic-color);
      border-radius: 0 0 9px 9px;
      animation-name: fadeIn;
      animation-duration: 0.5s;
      @media ${({ theme }) => theme.device.tablet} {
        height: 12px;
      }
    }
  }
  @media ${({ theme }) => theme.device.tablet} {
    min-width: fit-content;
    width: fit-content;
    &.selected::before {
      width: 60px;
      top: -36px;
    }
  }
  @media only screen and (max-width: 600px) {
    /* @media ${({ theme }) => theme.device.mobile} { */
    width: fit-content;
    min-width: fit-content;

    &.selected::before {
      width: 50px;
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

  @media only screen and (max-width: 800px) {
    width: 160px;
  }
  @media ${({ theme }) => theme.device.tablet} {
    width: 120px;
    padding: 5px 10px;
    height: 34px;
  }

  @media only screen and (max-width: 600px) {
    font-size: 10px;
    width: 108px;
  }

  @media (max-width: 375px) {
    display: none;
  }
`;

export default Nav;
