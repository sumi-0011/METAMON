import { Flex } from '@/components/common/flex';
import styled from 'styled-components';

function Header() {
  return (
    <Wrapper>
      <LeftBox>
        <Logo>MEMAMON</Logo>
        <SearchWrapper>
          <input type="text" />
        </SearchWrapper>
      </LeftBox>
      <RightBox>
        <div>METAMON 소개</div>
        <div>사용 방법</div>
        <SignInWrapper>Sign in</SignInWrapper>
      </RightBox>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  height: 70px;
  background-color: #fff;
  padding: 15px 30px;

  display: flex;
  justify-content: space-between;
`;

const LeftBox = styled(Flex)`
  gap: 50px;
  height: 40px;
`;

const RightBox = styled(Flex)`
  gap: 50px;
  color: #a1a1a1;
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

const Logo = styled.div`
  color: var(--basic-color);
  font-size: 1.875rem;
  font-weight: bold;
  line-height: 40px;
`;

const SearchWrapper = styled.div`
  input {
    box-sizing: border-box;
    width: 250px;
    height: 39px;
    padding: 10px 20px;
    border-radius: 20px;
    border: 1px solid #707070;
  }
`;
export default Header;
