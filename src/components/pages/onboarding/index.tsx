import MainSection from '@/components/pages/onboarding/main-section';
import styled from 'styled-components';

function Onboarding() {
  return (
    <Wrapper>
      <MainSection />
    </Wrapper>
  );
}

const Title = styled.h1`
  color: #fff;
  line-height: 45px;
  font-size: 30px;
`;

const Wrapper = styled.div`
  /* max-width: 1000px; */
  width: 100%;
  margin: auto;
`;

export default Onboarding;
