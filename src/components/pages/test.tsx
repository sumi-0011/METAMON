import React, { useEffect, useRef, useState } from 'react';
import S3 from 'react-aws-s3';

function Test() {
  useEffect(() => {
    window.Buffer = window.Buffer || require('buffer').Buffer;
  }, []);

  //file upload to storage & show preview
  const [selectedFile, setSelectedFile] = useState(
    'https://cdn.crowdpic.net/list-thumb/thumb_l_4291713E6EC8D22461618B2107D30880.jpg',
  );

  const config = {
    bucketName: process.env.NEXT_PUBLIC_BUCKET_NAME,
    region: process.env.NEXT_PUBLIC_REGION,
    accessKeyId: process.env.NEXT_PUBLIC_ACCESS,
    secretAccessKey: process.env.NEXT_PUBLIC_SECRET,
  };

  const handleFileInput = (e) => {
    setSelectedFile(e.target.files[0]);
    if (e.target.files[0].name.length > 0) {
      uploadFile(e.target.files[0]);
    }
  };

  const uploadFile = async (file) => {
    console.log('file: ', file);
    const ReactS3Client = new S3(config);
    console.log('ReactS3Client: ', ReactS3Client);
    // the name of the file uploaded is used to upload it to S3
    if (
      file.type === 'image/jpeg' ||
      file.type === 'image/png' ||
      file.type === 'image/jpg'
    ) {
      ReactS3Client.uploadFile(file, file.name)
        .then((data) => {
          console.log('data: ', data);
          console.log(data.location);
          setSelectedFile(data.location);
        })
        .catch((err) => console.error(err));
    }
  };

  return (
    <div>
      <input type="file" id="fileUpload" onChange={handleFileInput} />
    </div>
  );
}

export default Test;
