export * from './fileController.service';
import { FileControllerService } from './fileController.service';
export * from './postController.service';
import { PostControllerService } from './postController.service';
export * from './testController.service';
import { TestControllerService } from './testController.service';
export * from './userController.service';
import { UserControllerService } from './userController.service';
export const APIS = [FileControllerService, PostControllerService, TestControllerService, UserControllerService];
