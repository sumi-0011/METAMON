import Slider from '@/components/pages/intro/slider';
import useScrollFadeIn from '@/hooks/useScrollFadeIn';
import styled from 'styled-components';

const images = ['/static/intro/2.png', '/static/intro/3.png'];

function IntroPage() {
  const animatedItem1 = useScrollFadeIn('up', 1, 0);
  const animatedItem2 = useScrollFadeIn('up', 1, 1);
  return (
    <Wrapper>
      <Title {...animatedItem1}>안녕하세요.</Title>
      <Title {...animatedItem2}>METAMON을 소개합니다.</Title>
      <Slider images={images} />
    </Wrapper>
  );
}

const Title = styled.h1`
  color: #fff;
  line-height: 45px;
  font-size: 30px;
  @media ${({ theme }) => theme.device.tablet} {
    font-size: 24px;
    line-height: normal;
  }
`;

const Wrapper = styled.div`
  max-width: 1000px;
  width: 100%;
  margin: auto;
  padding: 65px 30px;
  height: fit-content;
  max-height: 768px;
`;
export default IntroPage;
