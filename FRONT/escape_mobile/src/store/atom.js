import { atom } from "recoil";

export const initialDatas = atom({
  key: 'initialDatas', // unique ID (with respect to other atoms/selectors)
  default: '', // default value (aka initial value)
});