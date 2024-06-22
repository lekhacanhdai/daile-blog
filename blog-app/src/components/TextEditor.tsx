import {CKEditor} from "@ckeditor/ckeditor5-react";
import Editor from "./Editor.tsx";

export default function TextEditor() {
    return <>
        <CKEditor
            editor={Editor}
            data={"<p>Hello</p>"}
            onChange={(_, editor) => {
                const data = editor.getData();
                console.log(data)
            } 
        }
        />
    </>
}