import { NativeModules } from 'react-native';

type ConfigType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Config } = NativeModules;

export default Config as ConfigType;
