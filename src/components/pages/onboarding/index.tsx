import MainSection from '@/components/pages/onboarding/main-section';
import Section1 from '@/components/pages/onboarding/section-1';
import Section2 from '@/components/pages/onboarding/section-2';
import Section3 from '@/components/pages/onboarding/section-3';
import styled from 'styled-components';

function Onboarding() {
  return (
    <Wrapper>
      <MainSection />
      <Section1 />
      <Divider />
      <Section2 />
      <Divider />
      <Section3 />
    </Wrapper>
  );
}

const Title = styled.h1`
  color: #fff;
  line-height: 45px;
  font-size: 30px;
`;

const Divider = styled.hr`
  margin-top: 150px;
`;
const Wrapper = styled.div`
  width: 100%;
  margin: auto;
  background-color: #fff;
`;

export default Onboarding;
