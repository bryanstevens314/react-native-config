#import <React/RCTBridgeModule.h>

@interface RNConfig : NSObject <RCTBridgeModule>
@end

@implementation RNConfig

RCT_EXPORT_MODULE();

- (NSDictionary *)constantsToExport
{
    return [[NSBundle mainBundle] infoDictionary];
}

+ (BOOL)requiresMainQueueSetup
{
  return YES;
}

@end
