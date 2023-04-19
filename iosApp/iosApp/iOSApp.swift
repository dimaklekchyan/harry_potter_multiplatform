import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        PlatformSDK().doInit(platformConfiguration: PlatformConfiguration())
    }
	var body: some Scene {
		WindowGroup {
            MainScreen()
		}
	}
}
