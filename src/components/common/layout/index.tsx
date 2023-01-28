import Header from '@/components/common/layout/header';
import { ReactNode } from 'react';
import styled from 'styled-components';

interface LayoutProps {
  children: ReactNode;
}

function Layout({ children }: LayoutProps) {
  return (
    <Wrapper>
      <HeaderContainer>
        <Header />
      </HeaderContainer>
      <MainContainer>{children}</MainContainer>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  height: 100%;

  background-color: var(--basic-color);
`;

const HeaderContainer = styled.header`
  position: absolute;
  width: 100%;
`;

const MainContainer = styled.main`
  width: 100%;
  padding-top: 70px;
  min-height: 100vh;
`;

export default Layout;
