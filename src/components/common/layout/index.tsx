import Header from '@/components/common/layout/header';
import { ReactNode } from 'react';
import styled from 'styled-components';

interface LayoutProps {
  children: ReactNode;
}

function Layout({ children }: LayoutProps) {
  return (
    <Wrapper>
      <Header />
      <main>{children}</main>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  height: 100vh;

  background-color: var(--basic-color);
`;

export default Layout;
