import Slider from '@/components/pages/intro/slider';
import styled from 'styled-components';

const images = ['/static/intro/1.png'];

function WayPage() {
  return (
    <Wrapper>
      <Title>안녕하세요.</Title>
      <Title> METAMON의 사용 방법을 안내해드리겠습니다.</Title>
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

export default WayPage;
