const deviceSizes = {
  mobile: '475px',
  tablet: '768px',
  laptop: '1024px',
  desktop: '1400px',
};

const device = {
  mobile: `screen and (max-width: ${deviceSizes.mobile})`,
  tablet: `screen and (max-width: ${deviceSizes.tablet})`,
  laptop: `screen and (max-width: ${deviceSizes.laptop})`,
  desktop: `screen and (max-width: ${deviceSizes.desktop})`,
};

const theme = {
  device,
};

export default theme;
