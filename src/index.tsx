import { NativeModules } from 'react-native';

type ConfigType = {
  BUILD_ENV: String;
};

const { RNConfig } = NativeModules;

export default RNConfig as ConfigType;
