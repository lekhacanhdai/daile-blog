import { FileLoader, UploadAdapter, UploadResponse } from 'ckeditor5';

interface CustomUploadAdapterProps {
  loader: FileLoader;
  url: string;
}

class CustomUploadAdapter implements UploadAdapter {
  loader: FileLoader;
  url: string;

  constructor(props: CustomUploadAdapterProps) {
    this.loader = props.loader;
    this.url = props.url;
  }

  upload(): Promise<UploadResponse> {
    return this.loader.file.then(
      (file: File | null) =>
        new Promise<UploadResponse>((resolve, reject) => {
          if (file) {
            const formData = new FormData();
            formData.append('file', file);

            fetch(this.url, {
              method: 'POST',
              body: formData,
            })
              .then((response) => response.json())
              .then((result) => {
                if (result?.success) {
                  resolve({
                    default: `https://cdn.daile.tech/assets/${result.data.path}`,
                  });
                }
              })
              .catch(reject);
          }
        }),
    );
  }

  abort(): void {
    // Handle the abort request.
  }
}

export default CustomUploadAdapter;
