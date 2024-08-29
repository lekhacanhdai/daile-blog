interface CustomUploadAdapterProps {
    loader: any;
    url: string;
}

class CustomUploadAdapter {
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
                        resolve({
                            default: "http://localhost:7000/daie-blog/ad1a93911feeb84c8b66496abc440d16.jpg",
                        });
                    })
                    .catch(reject);
            }));
    }

    abort() {
        // Handle the abort request.
    }
}

export default CustomUploadAdapter;