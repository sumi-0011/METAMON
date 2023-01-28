import Slider from '@/components/pages/onboarding/slider';
import { Example } from '@/components/pages/onboarding/sliderTest';
import styled from 'styled-components';

function Onboarding() {
  return (
    <Wrapper>
      <Title>안녕하세요.</Title>
      <Title>METAMON을 소개합니다.</Title>
      <Slider />
      {/* <Slider /> */}
    </Wrapper>
  );
}

const Title = styled.h1`
  color: #fff;
  line-height: 45px;
  font-size: 30px;
`;

const Wrapper = styled.div`
  max-width: 1000px;
  width: 100%;
  margin: auto;
  padding: 65px 10px;
`;

export default Onboarding;
