import Image from 'next/image';
import styled from 'styled-components';

function MainSection() {
  return (
    <Wrapper>
      <LeftBox>
        <Image
          src={'/static/meta-white-text.png'}
          alt="metamon-text-logo"
          width={420}
          height={72}
        />
        <h2>당신을 위한 메타버스 신분증</h2>
      </LeftBox>
      <RightImage>
        <Image
          src={'/static/meta-grey.png'}
          alt="meta-grey"
          width={700}
          height={487}
        />
      </RightImage>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  position: relative;
  height: calc(100vh - 95px);
  width: 100%;
`;
const LeftBox = styled.div`
  position: absolute;
  left: 180px;
  top: 212px;
  color: #fff;

  h2 {
    margin-top: 48px;
    font-size: 30px;
  }
`;

const RightImage = styled.div`
  height: 537px;
  width: 650px;
  position: absolute;
  right: -80px;
  top: 63px;
  bottom: 0;
`;
export default MainSection;
