import '/public/static/fonts/style.css';
import '@/styles/globals.css';

import type { AppProps } from 'next/app';
import { DefaultSeo } from 'next-seo';
import Layout from '@/components/common/layout';
import { ThemeProvider } from 'styled-components';
import theme from '@/styles/theme';

const DEFAULT_SEO = {
  title: 'METAMON',
  description: 'metamon site',
  canonical: 'https://www.carrotins.com',
  openGraph: {
    type: 'website',
    locale: 'ko_KR',
    url: 'http://metamon.hackathon.sparcs.org/',
    title: '내 정체성을 지켜주는 메타버스 신분증',
    site_name: 'METAMON',
    images: [
      {
        url: '/static/meta-blue-box.png',
        width: 285,
        height: 285,
        alt: 'meta-blue-box',
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
