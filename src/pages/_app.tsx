import '/public/static/fonts/style.css';
import '@/styles/globals.css';

import type { AppProps } from 'next/app';
import { DefaultSeo } from 'next-seo';
import Layout from '@/components/common/layout';
import { ThemeProvider } from 'styled-components';
import theme from '@/styles/theme';

const DEFAULT_SEO = {
  title: 'Metamon',
  description: 'metamon site',
  canonical: 'https://www.carrotins.com',
  openGraph: {
    type: 'website',
    locale: 'ko_KR',
    url: '카카오톡, 페이스북에 링크 넣으면 연결되는 url',
    title: '카카오톡, 페이스북에 링크 넣으면 올라올 타이틀',
    site_name: '사이트이름',
    images: [
      {
        url: '카카오톡, 페이스북에에 링크 넣으면 올라올 이미지',
        width: 285,
        height: 167,
        alt: '이미지',
      },
    ],
  },
};

export default function App({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={theme}>
      <DefaultSeo {...DEFAULT_SEO} />
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </ThemeProvider>
  );
}
