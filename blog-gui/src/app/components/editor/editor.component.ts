import {AfterViewInit, ChangeDetectorRef, Component, ViewEncapsulation} from '@angular/core';

import {
  ClassicEditor,
  AccessibilityHelp,
  Alignment,
  Autoformat,
  AutoImage,
  AutoLink,
  Autosave,
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
  FullPage,
  GeneralHtmlSupport,
  Heading,
  Highlight,
  HorizontalLine,
  HtmlComment,
  HtmlEmbed,
  ImageBlock,
  ImageCaption,
  ImageInline,
  ImageInsert,
  ImageInsertViaUrl,
  ImageResize,
  ImageStyle,
  ImageTextAlternative,
  ImageToolbar,
  ImageUpload,
  Indent,
  IndentBlock,
  Italic,
  Link,
  LinkImage,
  List,
  ListProperties,
  MediaEmbed,
  Paragraph,
  PasteFromOffice,
  RemoveFormat,
  SelectAll,
  SimpleUploadAdapter,
  SourceEditing,
  SpecialCharacters,
  SpecialCharactersArrows,
  SpecialCharactersCurrency,
  SpecialCharactersEssentials,
  SpecialCharactersLatin,
  SpecialCharactersMathematical,
  SpecialCharactersText,
  Strikethrough,
  Style,
  Subscript,
  Superscript,
  Table,
  TableCaption,
  TableCellProperties,
  TableColumnResize,
  TableProperties,
  TableToolbar,
  TextTransformation,
  TodoList,
  Underline,
  Undo,
  type EditorConfig, Editor, FileLoader
} from 'ckeditor5';
import CustomUploadAdapter from './custom-image-adapter';
import {ChangeEvent} from '@ckeditor/ckeditor5-angular';
import {PostService} from '../../services/post.service';
import {ResponseIdDTO} from '../../open-api';
import {Router} from '@angular/router';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrl: './editor.component.scss',
  encapsulation: ViewEncapsulation.None
})
export class AppEditor implements AfterViewInit{
  constructor(private changeDetector: ChangeDetectorRef, private postService: PostService, private _router: Router) {}

  public isLayoutReady = false;
  public Editor = ClassicEditor;
  public config: EditorConfig = {}; // CKEditor needs the DOM tree before calculating the configuration.

  public ngAfterViewInit(): void {
    function MyCustomUploadAdapterPlugin(editor: Editor) {
      editor.plugins.get('FileRepository').createUploadAdapter = (loader: FileLoader) => {
        return new CustomUploadAdapter({ loader, url: 'https://api.daile.tech/files' });
      };
    }
    this.config = {
      toolbar: {
        items: [
          'undo',
          'redo',
          '|',
          'sourceEditing',
          'findAndReplace',
          '|',
          'heading',
          'style',
          '|',
          'fontSize',
          'fontFamily',
          'fontColor',
          'fontBackgroundColor',
          '|',
          'bold',
          'italic',
          'underline',
          'strikethrough',
          'subscript',
          'superscript',
          'code',
          'removeFormat',
          '|',
          'specialCharacters',
          'horizontalLine',
          'link',
          'insertImage',
          'mediaEmbed',
          'insertTable',
          'highlight',
          'blockQuote',
          'codeBlock',
          'htmlEmbed',
          '|',
          'alignment',
          '|',
          'bulletedList',
          'numberedList',
          'todoList',
          'outdent',
          'indent'
        ],
        shouldNotGroupWhenFull: true
      },

      codeBlock: {
        languages: [
          { language: 'plaintext', label: 'Plain text' },
          { language: 'javascript', label: 'JavaScript' },
          { language: 'typescript', label: 'TypeScript' },
          { language: 'json', label: 'JSON' },
          { language: 'html', label: 'HTML' },
          { language: 'css', label: 'CSS' },
          { language: 'xml', label: 'XML' },
          { language: 'python', label: 'Python' },
          { language: 'java', label: 'Java' },
          { language: 'csharp', label: 'C#' },
          { language: 'cpp', label: 'C++' },
          { language: 'ruby', label: 'Ruby' },
          { language: 'php', label: 'PHP' },
          { language: 'bash', label: 'Bash/Shell' },
          { language: 'sql', label: 'SQL' },
          { language: 'yaml', label: 'YAML' },
          { language: 'markdown', label: 'Markdown' },
          { language: 'rust', label: 'Rust' },
          { language: 'kotlin', label: 'Kotlin' },
          { language: 'swift', label: 'Swift' },
          { language: 'r', label: 'R' },
          { language: 'perl', label: 'Perl' },
          { language: 'powershell', label: 'PowerShell' },
          { language: 'dart', label: 'Dart' },
          { language: 'objective-c', label: 'Objective-C' },
          { language: 'scala', label: 'Scala' },
          { language: 'haskell', label: 'Haskell' },
          { language: 'lua', label: 'Lua' }
        ] // Set default language if desired
      },
      plugins: [
        AccessibilityHelp,
        Alignment,
        Autoformat,
        AutoImage,
        AutoLink,
        Autosave,
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
        FullPage,
        GeneralHtmlSupport,
        Heading,
        Highlight,
        HorizontalLine,
        HtmlComment,
        HtmlEmbed,
        ImageBlock,
        ImageCaption,
        ImageInline,
        ImageInsert,
        ImageInsertViaUrl,
        ImageResize,
        ImageStyle,
        ImageTextAlternative,
        ImageToolbar,
        ImageUpload,
        Indent,
        IndentBlock,
        Italic,
        Link,
        LinkImage,
        List,
        ListProperties,
        MediaEmbed,
        Paragraph,
        PasteFromOffice,
        RemoveFormat,
        SelectAll,
        SimpleUploadAdapter,
        SourceEditing,
        SpecialCharacters,
        SpecialCharactersArrows,
        SpecialCharactersCurrency,
        SpecialCharactersEssentials,
        SpecialCharactersLatin,
        SpecialCharactersMathematical,
        SpecialCharactersText,
        Strikethrough,
        Style,
        Subscript,
        Superscript,
        Table,
        TableCaption,
        TableCellProperties,
        TableColumnResize,
        TableProperties,
        TableToolbar,
        TextTransformation,
        TodoList,
        Underline,
        MyCustomUploadAdapterPlugin,
        Undo
      ],
      fontFamily: {
        supportAllValues: true
      },
      fontSize: {
        options: [10, 12, 14, 'default', 18, 20, 22],
        supportAllValues: true
      },
      heading: {
        options: [
          {
            model: 'paragraph',
            title: 'Paragraph',
            class: 'ck-heading_paragraph'
          },
          {
            model: 'heading1',
            view: 'h1',
            title: 'Heading 1',
            class: 'ck-heading_heading1'
          },
          {
            model: 'heading2',
            view: 'h2',
            title: 'Heading 2',
            class: 'ck-heading_heading2'
          },
          {
            model: 'heading3',
            view: 'h3',
            title: 'Heading 3',
            class: 'ck-heading_heading3'
          },
          {
            model: 'heading4',
            view: 'h4',
            title: 'Heading 4',
            class: 'ck-heading_heading4'
          },
          {
            model: 'heading5',
            view: 'h5',
            title: 'Heading 5',
            class: 'ck-heading_heading5'
          },
          {
            model: 'heading6',
            view: 'h6',
            title: 'Heading 6',
            class: 'ck-heading_heading6'
          }
        ]
      },
      htmlSupport: {
        allow: [
          {
            name: /^.*$/,
            styles: true,
            attributes: true,
            classes: true
          }
        ]
      },
      extraPlugins: [MyCustomUploadAdapterPlugin],
      image: {
        toolbar: [
          'toggleImageCaption',
          'imageTextAlternative',
          '|',
          'imageStyle:inline',
          'imageStyle:wrapText',
          'imageStyle:breakText',
          '|',
          'resizeImage'
        ]
      },
      link: {
        addTargetToExternalLinks: true,
        defaultProtocol: 'https://',
        decorators: {
          toggleDownloadable: {
            mode: 'manual',
            label: 'Downloadable',
            attributes: {
              download: 'file'
            }
          }
        }
      },
      list: {
        properties: {
          styles: true,
          startIndex: true,
          reversed: true
        }
      },
      placeholder: 'Type or paste your content here!',
      style: {
        definitions: [
          {
            name: 'Article category',
            element: 'h3',
            classes: ['category']
          },
          {
            name: 'Title',
            element: 'h2',
            classes: ['document-title']
          },
          {
            name: 'Subtitle',
            element: 'h3',
            classes: ['document-subtitle']
          },
          {
            name: 'Info box',
            element: 'p',
            classes: ['info-box']
          },
          {
            name: 'Side quote',
            element: 'blockquote',
            classes: ['side-quote']
          },
          {
            name: 'Marker',
            element: 'span',
            classes: ['marker']
          },
          {
            name: 'Spoiler',
            element: 'span',
            classes: ['spoiler']
          },
          {
            name: 'Code (dark)',
            element: 'pre',
            classes: ['fancy-code', 'fancy-code-dark']
          },
          {
            name: 'Code (bright)',
            element: 'pre',
            classes: ['fancy-code', 'fancy-code-bright']
          }
        ]
      },
      table: {
        contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells', 'tableProperties', 'tableCellProperties']
      }
    };

    this.isLayoutReady = true;
    this.changeDetector.detectChanges();
  }

  public onChange( { editor }: ChangeEvent ) {
    this.data = editor.getData();
  }

  data = ''
  title = ''
  numRows = 1;

  autoExpand(event: any): void {
    const textarea = event.target;
    const lineHeight = 40; // Adjust line height as necessary
    const maxRows = 5; // Max number of rows to prevent indefinite expansion
    const minRows = 1; // Minimum number of rows
    const contentHeight = textarea.scrollHeight;
    const newRows = Math.floor(contentHeight / lineHeight);
    // Update rows based on content height, with bounds between minRows and maxRows
    this.numRows = Math.max(minRows, Math.min(newRows, maxRows));
  }


  savePost(): void {
    this.postService.createPost({title: this.title, content: this.data, status: 'PUBLISH', tagIds: []})
      .subscribe((res: ResponseIdDTO) => {
        if (res.success)
        this._router.navigate(["/posts"]).then(() => {})
      })
  }

  protected readonly console = console;


}

