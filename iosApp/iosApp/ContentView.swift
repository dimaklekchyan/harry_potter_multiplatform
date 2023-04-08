import SwiftUI
import shared

struct ContentView: View {
    
    private let viewModel = MainScreenViewModel()

    var body: some View {
        Button {
            viewModel.obtainEvent(viewEvent: MainEvent.AllCharactersClick())
        } label: {
            Text("Click here")
        }
     }
}
