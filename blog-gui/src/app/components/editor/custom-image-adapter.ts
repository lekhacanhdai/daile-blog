import {UploadAdapter} from 'ckeditor5';

interface CustomUploadAdapterProps {
  loader: any;
  url: string;
}

class CustomUploadAdapter implements UploadAdapter {
  loader: any;
  url: string;

  constructor(props: CustomUploadAdapterProps) {
    this.loader = props.loader;
    this.url = props.url;
  }

  upload() {
    return this.loader.file
      .then((file: File) => new Promise((resolve, reject) => {
        const formData = new FormData();
        formData.append('file', file);

        fetch(this.url, {
          method: 'POST',
          body: formData,
        })
          .then(response => response.json())
          .then(result => {
            if (result?.success) {
              resolve({
                default: `https://cdn.daile.tech/assets/${result.data.path}`
              });
            }
          })
          .catch(reject);
      }));
  }

  abort() {
    // Handle the abort request.
  }
}

export default CustomUploadAdapter;
