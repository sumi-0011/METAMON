import Footer from '@/components/common/layout/footer';
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
      <Footer />
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
  min-height: calc(100vh - 134px);
  display: flex;
  flex-direction: column;

  @media (max-width: 768px) {
    /* padding: 30px 20px; */
    overflow-x: hidden;
  }

  padding-top: 95px;
`;

export default Layout;
