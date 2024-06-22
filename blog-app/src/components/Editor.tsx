/**
 * @license Copyright (c) 2014-2024, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see LICENSE.md or https://ckeditor.com/legal/ckeditor-oss-license
 */

import { ClassicEditor } from '@ckeditor/ckeditor5-editor-classic';

import { Autoformat } from '@ckeditor/ckeditor5-autoformat';
import { Bold, Code, Italic, Underline } from '@ckeditor/ckeditor5-basic-styles';
import { BlockQuote } from '@ckeditor/ckeditor5-block-quote';
import { CodeBlock } from '@ckeditor/ckeditor5-code-block';
import type { EditorConfig } from '@ckeditor/ckeditor5-core';
import { Essentials } from '@ckeditor/ckeditor5-essentials';
import { FindAndReplace } from '@ckeditor/ckeditor5-find-and-replace';
import { FontBackgroundColor, FontColor, FontFamily, FontSize } from '@ckeditor/ckeditor5-font';
import { Heading, Title } from '@ckeditor/ckeditor5-heading';
import { Highlight } from '@ckeditor/ckeditor5-highlight';
import { GeneralHtmlSupport } from '@ckeditor/ckeditor5-html-support';
import {
    Image,
    ImageCaption,
    ImageInsert,
    ImageResize,
    ImageStyle,
    ImageToolbar,
    ImageUpload
} from '@ckeditor/ckeditor5-image';
import { Indent } from '@ckeditor/ckeditor5-indent';
import { Link, LinkImage } from '@ckeditor/ckeditor5-link';
import { List } from '@ckeditor/ckeditor5-list';
import { MediaEmbed } from '@ckeditor/ckeditor5-media-embed';
import { Paragraph } from '@ckeditor/ckeditor5-paragraph';
import { PasteFromOffice } from '@ckeditor/ckeditor5-paste-from-office';
import { SelectAll } from '@ckeditor/ckeditor5-select-all';
import { Style } from '@ckeditor/ckeditor5-style';
import {
    Table,
    TableCaption,
    TableCellProperties,
    TableColumnResize,
    TableProperties,
    TableToolbar
} from '@ckeditor/ckeditor5-table';
import { TextTransformation } from '@ckeditor/ckeditor5-typing';
import { Undo } from '@ckeditor/ckeditor5-undo';
import { Base64UploadAdapter } from '@ckeditor/ckeditor5-upload';

class Editor extends ClassicEditor {
    public static override builtinPlugins = [
        Autoformat,
        Base64UploadAdapter,
        BlockQuote,
        Bold,
        Code,
        CodeBlock,
        Essentials,
        FindAndReplace,
        FontBackgroundColor,
        FontColor,
        FontFamily,
        FontSize,
        GeneralHtmlSupport,
        Heading,
        Highlight,
        Image,
        ImageCaption,
        ImageInsert,
        ImageResize,
        ImageStyle,
        ImageToolbar,
        ImageUpload,
        Indent,
        Italic,
        Link,
        LinkImage,
        List,
        MediaEmbed,
        Paragraph,
        PasteFromOffice,
        SelectAll,
        Style,
        Table,
        TableCaption,
        TableCellProperties,
        TableColumnResize,
        TableProperties,
        TableToolbar,
        TextTransformation,
        Title,
        Underline,
        Undo
    ];

    public static override defaultConfig: EditorConfig = {
        toolbar: {
            items: [
                'heading',
                '|',
                'bold',
                'italic',
                'link',
                'bulletedList',
                'numberedList',
                '|',
                'outdent',
                'indent',
                '|',
                'imageUpload',
                'blockQuote',
                'insertTable',
                'mediaEmbed',
                'undo',
                'redo'
            ]
        },
        language: 'en',
        image: {
            toolbar: [
                'imageTextAlternative',
                'toggleImageCaption',
                'imageStyle:inline',
                'imageStyle:block',
                'imageStyle:side',
                'linkImage'
            ]
        },
        table: {
            contentToolbar: [
                'tableColumn',
                'tableRow',
                'mergeTableCells',
                'tableCellProperties',
                'tableProperties'
            ]
        }
    };
}

export default Editor;
