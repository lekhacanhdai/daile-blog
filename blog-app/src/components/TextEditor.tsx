import {CKEditor} from "@ckeditor/ckeditor5-react";
import Editor from "./Editor.tsx";

export default function TextEditor() {
    return <>
        <CKEditor
            editor={Editor}
            data={"<p>Hi, I'm Dai</p><span>This web page will be coming soon!</span>"}
            onChange={(_, editor) => {
                const data = editor.getData();
                console.log(data)
            } 
        }
        />
    </>
}