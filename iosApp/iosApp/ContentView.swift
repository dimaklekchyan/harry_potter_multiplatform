import SwiftUI
import shared

//struct ContentView: View {
//    
//    @ObservedObject private(set) var viewModel: CharactersViewModel
//
//    var body: some View {
//         NavigationView {
//             listView()
//             .navigationBarTitle("HarryPotter Characters")
//             .navigationBarItems(trailing:
//                 Button("Reload") {
//                     self.viewModel.loadCharacters(forceReload: true)
//             })
//         }
//     }
//    
//    private func listView() -> AnyView {
//         switch viewModel.characters {
//         case .loading:
//             return AnyView(Text("Loading...").multilineTextAlignment(.center))
//         case .result(let characters):
//             return AnyView(List(characters) { character in
//                 CharacterRow(character: character)
//             })
//         case .error(let description):
//             return AnyView(Text(description).multilineTextAlignment(.center))
//         }
//     }
//}
//
//extension ContentView {
//    enum LoadableCharacters {
//        case loading
//        case result([Character])
//        case error(String)
//    }
//
//   class CharactersViewModel: ObservableObject {
//       let repository: HarryPotterRepository
//       
//       init(repository: HarryPotterRepository) {
//           self.repository = repository
//           self.loadCharacters(forceReload: true)
//       }
//       
//       @Published var characters = LoadableCharacters.loading
//       
//       func loadCharacters(forceReload: Bool) {
//           self.characters = .loading
//                repository.getCharacters(forceReload: forceReload, completionHandler: { characters, error in
//                    if let characters = characters {
//                           self.characters = .result(characters)
//                       } else {
//                           self.characters = .error(error?.localizedDescription ?? "error")
//                       }
//                    }
//                )
//       }
//   }
//}
//
//extension Character: Identifiable {}
